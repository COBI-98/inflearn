package hello.upload.domain;

import lombok.Data;

@Data
public class UploadFile {

    private String uploadFileName; // 고객 업로드 파일명
    private String storeFileName; // 서버 내부 관리 파일명 UUID관리

    public UploadFile(String uploadFileName, String storeFileName) {
        this.uploadFileName = uploadFileName;
        this.storeFileName = storeFileName;
    }
}
