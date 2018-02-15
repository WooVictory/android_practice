package app.cosmos.a20180116java.SixExam.Register;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

import app.cosmos.a20180116java.FontExam.ApplicationController;
import app.cosmos.a20180116java.R;
import app.cosmos.a20180116java.SixExam.Network.NetworkService;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.inputWriterEdit)
    EditText inputWriterEdit;
    @BindView(R.id.inputTitleEdit)
    EditText inputTitleEdit;
    @BindView(R.id.inputContentEdit)
    EditText inputContentEdit;
    @BindView(R.id.text_length)
    TextView text_length;
    @BindView(R.id.addImageName)
    TextView ImageName; // 사진 이름
    @BindView(R.id.getImageBtn)
    Button getImageBtn; // 사진 첨부 버튼
    @BindView(R.id.completeBtn)
    Button completeBtn;

    final int REQ_CODE_SELECT_IMAGE=100;
    String imgUrl = "";
    Uri data;
    NetworkService networkService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        networkService = ApplicationController.getInstance().getNetworkService();
        // 서비스 객체 초기화


        /*FIXME
        * text 필드의 텍스트 길이를 출력
        * */
        inputContentEdit.addTextChangedListener(new TextWatcher() {
            String strCur;
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {
                strCur = s.toString();
            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                text_length.setText(String.valueOf(s.length())+"/500");
                // 텍스트가 변화하는 중간 중간 값이 바뀌어야 하므로 여기서 설정한다.
                // 입력되는 텍스트는 변화하는 중이므로 여기서 코드를 작성
                // 입력되는 텍스트의 길이를 가져와서 텍스트뷰에 표시한다.

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        /*FIXME
        EditText는 inputType 속성이나 max 속성을 이용해서 입력형이나 문자 수를 제한할 수 있지만, 정의한 것 외에는 필터링할 수 없다.
        그러나 inputFilters를 사용하면 문자 수 제한뿐만 아니라 정규 표현을 이용해서 입력을 세밀하게 제어할 수 있고, InputFilter 자체도
        여러개 설정할 수 있어 매우 편리하다.
        여기서는 글자 수를 500자로 제한하고 있다.

        * */
        InputFilter[] inputFilters = new InputFilter[1];
        inputFilters[0] = new InputFilter.LengthFilter(500);
        inputContentEdit.setFilters(inputFilters);



    }
    @OnClick({R.id.getImageBtn,R.id.completeBtn})
    void click(View view)
    {
        switch (view.getId())
        {
            case R.id.getImageBtn:
                /*FIXME
                갤러리를 호출
                * */
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
                intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, REQ_CODE_SELECT_IMAGE);
                // REQ_CODE_SELECT_IMAGE -> 이것은 요청 코드를 갤러리에 접근할 때 요청코드로 보낸다.
                break;
            case R.id.completeBtn:
                if(inputTitleEdit.length() == 0 || inputContentEdit.length() == 0)
                {
                    showToast("제목 및 내용을 입력해주세요.");
                }else {
                    RequestBody title = RequestBody.create(MediaType.parse("multipart/form-data"),inputTitleEdit.getText().toString());
                    RequestBody content = RequestBody.create(MediaType.parse("multipart/form-data"),inputContentEdit.getText().toString());
                    RequestBody writer = RequestBody.create(MediaType.parse("multipart/form-data"),inputWriterEdit.getText().toString());
                    // 이미지를 제외한 다른 데이터를 RequestBody 타입에 맞게 변환하는 과정이다.

                    MultipartBody.Part body;

                    if(imgUrl=="") {
                        body = null;
                    }else {
                        /*FIXME
                        이미지를 리사이징하는 부분
                        이미지의 크기가 크면 메모리를 너무 많이 차지하기 때문에
                        리사이징을 통해서 메모리를 줄이고 해상도를 유지할 수 있도록 한다.
                        * */

                        BitmapFactory.Options options = new BitmapFactory.Options();
                        //options.inSampleSize = 4; // 얼마나 줄일지 설정하는 옵션으로 4라는 의미는 1/4로 줄이겠다는 의미이다.

                        InputStream in =null;
                        try {
                            in = getContentResolver().openInputStream(data);

                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        /*FIXME
                        InputStream 형태로 받은 이미지로부터 비트맵을 만들어서 바이트 단위로 압축
                        그 이후 스트림 배열에 담아서 전송한다.
                        * */

                        Bitmap bitmap = BitmapFactory.decodeStream(in,null,options);
                        // inputStream으로부터 Bitmap을 만들어준다.
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        bitmap.compress(Bitmap.CompressFormat.JPEG,20,baos);
                        RequestBody photoBody = RequestBody.create(MediaType.parse("image/jpg"),baos.toByteArray());

                        File photo = new File(imgUrl);
                        body = MultipartBody.Part.createFormData("image",photo.getName(),photoBody);

                    }

                    Call<RegisterResult> registerResult = networkService.registerImageNotice(body,writer,title,content);
                    registerResult.enqueue(new Callback<RegisterResult>() {
                        @Override
                        public void onResponse(Call<RegisterResult> call, Response<RegisterResult> response) {
                            if(response.isSuccessful())
                            {
                                if(response.body().message.equals("save"))
                                {
                                    // 여기서는 글을 등록하는 것이기 때문에
                                    // 서버로 데이터를 보내고 성공 메시지를 받기만 하면 된다.
                                    Log.v("성공","성공");
                                    finish();
                                }
                            }else{
                                showToast("Error");
                            }
                        }

                        @Override
                        public void onFailure(Call<RegisterResult> call, Throwable t) {
                            showToast("Error");
                            Log.v("Failure3",t.getMessage());

                        }
                    });
                }
                break;
        }
    }


    /* 선택된 이미지 가져오기 */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQ_CODE_SELECT_IMAGE)
        {
            // 갤러리에 접근해서 이미지를 가져온 다음에 갤러리 쪽에서 setResult(RESULT_OK,intent) 함수를 호출하면서
            // 다시 RegisterActivity로 돌아오게 된다.
            //  그러면 onActivityResult() 쪽에서 받아서 처리하게 된다.
            if(resultCode == Activity.RESULT_OK)
            {
                try {

                    String nameStr = getImageNameToUri(data.getData());
                    // MediaStore.Images.Media.EXTERNAL_CONTENT_URI 이거를 가지고와서 getImageNameToUri 함수에 넣어준다.
                    ImageName.setText(nameStr);
                    // 위의 함수 호출을 통해서 가져온 이미지 파일의 이름을 텍스트 뷰에 설정한다.
                    this.data = data.getData();

                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            else{
                // resultCode가 RESULT_OK가 아니면 이미지 파일이 존재하지 않는다는 것이므로
                // 텍스트 뷰를 공백으로 -> 이미지가 없다는 것을 의미함.
                imgUrl = "";
                ImageName.setText("");
            }
        }
    }

    /* 선택된 이미지 파일명 가져오기 */
    public String getImageNameToUri(Uri data)
    {
        String [] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = managedQuery(data,proj,null,null,null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);

        cursor.moveToFirst();

        String imagePath = cursor.getString(column_index);
        String imageName = imagePath.substring(imagePath.lastIndexOf("/")+1);

        imgUrl = imagePath;
        return imageName;
    }

    public void showToast(String str)
    {
        Toast.makeText(getApplicationContext(), str,Toast.LENGTH_SHORT).show();
    }

}
