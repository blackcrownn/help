package help.help.dto;

import help.help.module.Yazi;

public class MediaDto {
    private String fileName;
    private String filePath;
    private String fileType;
    private Yazi yazi;

    public MediaDto(String fileName, String filePath, String fileType, Yazi yazi) {
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileType = fileType;
        this.yazi = yazi;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Yazi getYazi() {
        return yazi;
    }

    public void setYazi(Yazi yazi) {
        this.yazi = yazi;
    }
}
