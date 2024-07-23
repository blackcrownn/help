package help.help.module;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "medya")
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private Long id;

    private String fileName;
    private String filePath;
    private String fileType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "yazi_id")
    private Yazi yazi;

    public Media() {}

    public Media(String fileName, String filePath, String fileType, Yazi yazi) {
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileType = fileType;
        this.yazi = yazi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
