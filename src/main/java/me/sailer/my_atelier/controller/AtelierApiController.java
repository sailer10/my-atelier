package me.sailer.my_atelier.controller;

import lombok.RequiredArgsConstructor;
import me.sailer.my_atelier.domain.Atelier;
import me.sailer.my_atelier.dto.atelier.AddAtelierRequest;
import me.sailer.my_atelier.dto.atelier.AtelierResponse;
import me.sailer.my_atelier.dto.atelier.UpdateAtelierRequest;
import me.sailer.my_atelier.dto.atelier.UpdateAtelierStatusRequest;
import me.sailer.my_atelier.service.AtelierService;
import me.sailer.my_atelier.util.Urls;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(Urls.API_ATELIER)
public class AtelierApiController {

    private final AtelierService atelierService;

    /**
     * post 의 경우 새로 등록된 엔티티를 바로 body 에 넘겨줌
     * @param request
     * @return HttpEntity.body(Atelier)
     */
    @PostMapping
    public ResponseEntity<Atelier> createAtelier(@RequestBody AddAtelierRequest request) {
        Atelier savedAtelier = atelierService.saveAtelier(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedAtelier);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtelierResponse> getAtelier(@PathVariable Long id) {
        Atelier atelier = atelierService.findById(id);

        return ResponseEntity.ok().body(new AtelierResponse(atelier));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Atelier> updateAtelier(@PathVariable Long id,
                                                 @RequestBody UpdateAtelierRequest request) {
        Atelier updateAtelier = atelierService.updateAtelier(id, request);

        return ResponseEntity.ok().body(updateAtelier);
    }

    /**
     * 삭제하지 않고 영업종료로 status 바꿈
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAtelier(@PathVariable Long id) {

        atelierService.shutdownAtelier(id);

        return ResponseEntity.ok().build();
    }

    @PatchMapping(Urls.STATUS + "/{id}")
    public ResponseEntity<Void> updateAtelierStatus(@PathVariable Long id,
                                                @RequestBody UpdateAtelierStatusRequest request) {
        atelierService.updateAtelierStatus(id, request);

        return ResponseEntity.ok().build();
    }
}
