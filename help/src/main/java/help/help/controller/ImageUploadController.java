//
//package help.help.controller;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//
//@RestController
//@RequestMapping("/api/images")
//public class ImageUploadController {
//
//    @Autowired
//    private ImageUploadService imageUploadService;
//
//    @PostMapping("/upload")
//    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
//        try {
//            String fileName = imageUploadService.saveImage(file);
//            return ResponseEntity.ok(fileName);
//        } catch (IOException e) {
//            return ResponseEntity.status(500).body("Image upload failed");
//        }
//    }
//
//    @GetMapping("/{fileName}")
//    public ResponseEntity<byte[]> getImage(@PathVariable String fileName) {
//        try {
//            byte[] image = imageUploadService.getImage(fileName);
//            return ResponseEntity.ok()
//                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
//                    .contentType(MediaType.IMAGE_JPEG)
//                    .body(image);
//        } catch (IOException e) {
//            return ResponseEntity.status(404).body(null);
//        }
//    }
//}
