package help.help.controller;

import help.help.dto.SimpleYaziDto;
import help.help.dto.YaziDto;
import help.help.service.YaziService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/yazi")
@CrossOrigin
public class YaziController {

    @Autowired
    private YaziService yaziService;

    @PostMapping("/saveyazi")
    @CrossOrigin
    public ResponseEntity<YaziDto> saveYazi(@RequestBody YaziDto yaziDto) {
        YaziDto savedYazi = yaziService.save(yaziDto);
        return ResponseEntity.ok(savedYazi);
    }

    @GetMapping("/allyazi")
    @CrossOrigin
    public ResponseEntity<List<YaziDto>> getAllYazilar() {
        List<YaziDto> yazilar = yaziService.findAll();
        return ResponseEntity.ok(yazilar);
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<YaziDto> getYaziById(@PathVariable Long id) {
        YaziDto yaziDto = yaziService.getYaziById(id);
        return ResponseEntity.ok(yaziDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteYazi(@PathVariable Long id) {
        yaziService.deleteYazi(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/simple")
    public List<SimpleYaziDto> getSimpleYaziDto(){
        return yaziService.getAllSimpleYaziDtos();
    }
}






















