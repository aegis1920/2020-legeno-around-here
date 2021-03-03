package wooteco.team.ittabi.legenoaroundhere.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wooteco.team.ittabi.legenoaroundhere.dto.AreaResponse;
import wooteco.team.ittabi.legenoaroundhere.dto.PageRequest;
import wooteco.team.ittabi.legenoaroundhere.dto.PageableAssembler;
import wooteco.team.ittabi.legenoaroundhere.service.AreaService;

@RestController
@RequiredArgsConstructor
public class AreaController {

    private final AreaService areaService;

    @GetMapping("/areas")
    public ResponseEntity<Page<AreaResponse>> searchAreas(PageRequest pageRequest,
        @RequestParam(defaultValue = "") String keyword) {
        Page<AreaResponse> areas
            = areaService.searchAreas(PageableAssembler.assemble(pageRequest), keyword);

        return ResponseEntity
            .ok(areas);
    }
}
