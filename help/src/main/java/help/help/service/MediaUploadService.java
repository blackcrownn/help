package help.help.service;

import help.help.module.Media;
import help.help.module.Yazi;
import help.help.repository.MediaRepository;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class MediaUploadService {


    public MediaUploadService(MediaRepository mediaRepository) {
        this.mediaRepository = mediaRepository;
    }

    private MediaRepository mediaRepository;

    private final String uploadDir = "uploads/";

    public Media saveMedia(MultipartFile file, Yazi yazi) throws IOException {
        if (file.isEmpty()) {
            throw new IOException("File is empty");
        }

        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        Path path = Paths.get(uploadDir + fileName);
        Files.createDirectories(path.getParent());
        Files.write(path, file.getBytes());

        Media media = new Media();
        media.setFileName(fileName);
        media.setFilePath(path.toString());
        media.setFileType(file.getContentType());


        return mediaRepository.save(media);
    }

    public byte[] getMedia(String fileName) throws IOException {
        Path path = Paths.get(uploadDir + fileName);
        return Files.readAllBytes(path);
    }

    public void deleteMedia(Long id) throws IOException {
        Media media = mediaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Media not found"));

        Path path = Paths.get(media.getFilePath());
        Files.deleteIfExists(path);

        mediaRepository.delete(media);
    }
}
