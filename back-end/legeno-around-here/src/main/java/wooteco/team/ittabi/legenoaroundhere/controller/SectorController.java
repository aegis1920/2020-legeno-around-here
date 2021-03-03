package wooteco.team.ittabi.legenoaroundhere.controller;

import java.net.URI;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wooteco.team.ittabi.legenoaroundhere.dto.PageRequest;
import wooteco.team.ittabi.legenoaroundhere.dto.PageableAssembler;
import wooteco.team.ittabi.legenoaroundhere.dto.SectorDetailResponse;
import wooteco.team.ittabi.legenoaroundhere.dto.SectorRequest;
import wooteco.team.ittabi.legenoaroundhere.dto.SectorResponse;
import wooteco.team.ittabi.legenoaroundhere.dto.SectorSimpleResponse;
import wooteco.team.ittabi.legenoaroundhere.service.SectorService;

@RestController
@RequiredArgsConstructor
public class SectorController {

    private final SectorService sectorService;

    @GetMapping("/sectors/{sectorId}")
    public ResponseEntity<SectorResponse> findAvailableSector(@PathVariable Long sectorId) {
        SectorResponse sector = sectorService.findAvailableSector(sectorId);

        return ResponseEntity
            .ok(sector);
    }

    @GetMapping("/sectors")
    public ResponseEntity<Page<SectorResponse>> searchAvailableSectors(PageRequest pageRequest,
        @RequestParam(defaultValue = "") String keyword) {
        Page<SectorResponse> sectors = sectorService
            .searchAvailableSectors(PageableAssembler.assemble(pageRequest), keyword);

        return ResponseEntity
            .ok(sectors);
    }

    @GetMapping("/sectors/simple")
    public ResponseEntity<List<SectorSimpleResponse>> findSectorsForKeywordSearch() {
        List<SectorSimpleResponse> sectors = sectorService.findAllAvailableSectors();

        return ResponseEntity
            .ok(sectors);
    }

    @PostMapping("/sectors")
    public ResponseEntity<Void> createPendingSector(@RequestBody SectorRequest sectorRequest) {
        SectorResponse sectorResponse = sectorService.createPendingSector(sectorRequest);
        Long sectorId = sectorResponse.getId();

        return ResponseEntity
            .created(URI.create("/sectors/" + sectorId))
            .build();
    }

    @GetMapping("/sectors/me")
    public ResponseEntity<Page<SectorDetailResponse>> findMySectors(PageRequest pageRequest) {
        Page<SectorDetailResponse> sectorDetailResponses
            = sectorService.findMySectors(PageableAssembler.assemble(pageRequest));

        return ResponseEntity
            .ok(sectorDetailResponses);
    }

    @GetMapping("/sectors/best")
    public ResponseEntity<List<SectorSimpleResponse>> findBestSectors(
        @RequestParam(defaultValue = "4") int count) {
        List<SectorSimpleResponse> sectors = sectorService.findBestSectors(count);

        return ResponseEntity
            .ok(sectors);
    }
}
