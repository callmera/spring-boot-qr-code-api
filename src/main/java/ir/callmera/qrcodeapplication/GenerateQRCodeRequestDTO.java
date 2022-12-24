package ir.callmera.qrcodeapplication;

public class GenerateQRCodeRequestDTO {

    private String content;
    private Integer width;
    private Integer height;

    public GenerateQRCodeRequestDTO(String content, Integer width, Integer height) {
        this.content = content;
        this.width = width;
        this.height = height;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}
