package com.lxy.vod;

import com.aliyun.vod.upload.impl.UploadVideoImpl;
import com.aliyun.vod.upload.req.UploadVideoRequest;
import com.aliyun.vod.upload.resp.UploadVideoResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.vod.model.v20170321.GetPlayInfoRequest;
import com.aliyuncs.vod.model.v20170321.GetPlayInfoResponse;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthRequest;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthResponse;
import org.junit.Test;

import java.util.List;

public class TestVod {

    public static final String ACCESS_KEY_ID = "LTAI5tCpVW3MButsah5Vts2r";
    public static final String ACCESS_KEY_SECRET = "YcTS6DxW2AeuqviWp8nPaxpGtg32mO";

    public static final String TEST_VIDEO_ID = "aa254c152fcc41899f26a370efb0ab86";

    //1 根据视频iD获取视频播放地址
    @Test
    public void getPlayUrl() throws Exception {
        //创建初始化对象
        DefaultAcsClient client = InitObject.initVodClient(ACCESS_KEY_ID, ACCESS_KEY_SECRET);

        //创建获取视频地址request和response
        GetPlayInfoRequest request = new GetPlayInfoRequest();

        //向request对象里面设置视频id
        request.setVideoId(TEST_VIDEO_ID);

        //调用初始化对象里面的方法，传递request，获取数据
        GetPlayInfoResponse response = client.getAcsResponse(request);

        List<GetPlayInfoResponse.PlayInfo> playInfoList = response.getPlayInfoList();
        //播放地址
        for (GetPlayInfoResponse.PlayInfo playInfo : playInfoList) {
            System.out.print("视频播放地址:" + playInfo.getPlayURL() + "\n");
        }
        //Base信息
        System.out.print("视频标题:" + response.getVideoBase().getTitle() + "\n");
    }

    //2 根据视频iD获取视频播放凭证(加密过的视频需要播放凭证才能播放)
    @Test
    public void getPlayAuth() throws Exception {
        DefaultAcsClient client = InitObject.initVodClient(ACCESS_KEY_ID, ACCESS_KEY_SECRET);

        GetVideoPlayAuthRequest request = new GetVideoPlayAuthRequest();
        //设置播放凭证的有效期(默认值：100秒  取值范围：100~3000)
        request.setAuthInfoTimeout(200L);
        request.setVideoId(TEST_VIDEO_ID);

        GetVideoPlayAuthResponse response = client.getAcsResponse(request);
        System.out.println("播放凭证:" + response.getPlayAuth());
    }

    //3 本地文件上传视频测试
    @Test
    public void uploadVideo() {
        String title = "test-video";   //上传之后文件名称
        String fileName = "F:/test-video.mp4";  //本地文件路径和名称
        //上传视频的方法
        UploadVideoRequest request = new UploadVideoRequest(ACCESS_KEY_ID, ACCESS_KEY_SECRET, title, fileName);
        /* 可指定分片上传时每个分片的大小，默认为2M字节 */
        request.setPartSize(2 * 1024 * 1024L);
        /* 可指定分片上传时的并发线程数，默认为1，(注：该配置会占用服务器CPU资源，需根据服务器情况指定）*/
        request.setTaskNum(1);

        UploadVideoImpl uploader = new UploadVideoImpl();
        UploadVideoResponse response = uploader.uploadVideo(request);

        if (response.isSuccess()) {
            System.out.print("VideoId=" + response.getVideoId() + "\n");
        } else {
            /* 如果设置回调URL无效，不影响视频上传，可以返回VideoId同时会返回错误码。其他情况上传失败时，VideoId为空，此时需要根据返回错误码分析具体错误原因 */
            System.out.print("VideoId=" + response.getVideoId() + "\n");
            System.out.print("ErrorCode=" + response.getCode() + "\n");
            System.out.print("ErrorMessage=" + response.getMessage() + "\n");
        }
    }
}
