package me.sailer.my_atelier.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.sailer.my_atelier.domain.Atelier;
import me.sailer.my_atelier.dto.atelier.AddAtelierRequest;
import me.sailer.my_atelier.dto.atelier.UpdateAtelierRequest;
import me.sailer.my_atelier.dto.atelier.UpdateAtelierStatusRequest;
import me.sailer.my_atelier.enums.AtelierStatus;
import me.sailer.my_atelier.repository.AtelierRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AtelierService {

    private final AtelierRepository atelierRepository;

    public Atelier saveAtelier(AddAtelierRequest request) {
        Atelier atelier = atelierRepository.save(request.toEntity());
        return atelierRepository.save(atelier);
    }

    public Atelier findById(Long id) {
        return atelierRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("찾는 공방이 없습니다!"));
    }

    @Transactional
    public Atelier updateAtelier(Long id, UpdateAtelierRequest request) {
        Atelier atelier = atelierRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("공방 못찾음"));

        // todo: 해당 공방의 관리자인지 확인
        atelier.update(request.getName(), request.getAddress(), request.getStatus());
        //todo: (중요도:하) 엔티티를 넘기는게 아닌 DTO 넘기게 변경해야함.
        return atelier;
    }

    @Transactional
    public Atelier updateAtelierStatus(Long id, UpdateAtelierStatusRequest request) {
        Atelier atelier = atelierRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("공방 못찾음"));

        // todo: 해당 공방의 관리자인지 확인
        atelier.changeAtelierStatus(AtelierStatus.ofCode(request.getStatus()));
        return atelier;
    }

    public void shutdownAtelier(Long id) {
        Atelier atelier = atelierRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("공방 못찾음"));
        atelier.changeAtelierStatus(AtelierStatus.SHUTDOWN);
    }


}
