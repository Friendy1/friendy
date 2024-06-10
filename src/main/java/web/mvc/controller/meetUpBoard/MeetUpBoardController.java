package web.mvc.controller.meetUpBoard;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.mvc.dto.meetUpBoard.MeetUpBoardDTO;
import web.mvc.service.meetUpBoard.MeetUpBoardService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/partyBoard")
@Slf4j
public class MeetUpBoardController {

    private final MeetUpBoardService meetUpBoardService;


    @PostMapping("/create")
    public ResponseEntity<?> createPartyBoard(@RequestBody MeetUpBoardDTO meetUpBoardDTO){
        //입력된 타입이 안맞으면 @RequestBody에서 애초에 걸러져버림. .

    String result =meetUpBoardService.createParty(meetUpBoardDTO);
        System.out.println(result+"결과");

        meetUpBoardService.findByPartySeq();

        return ResponseEntity.status(HttpStatus.OK).body("성공");
    }

    @GetMapping ("/test")
    public void test(){
//       meetUpBoardService.findByPartySeq();
       meetUpBoardService.checkDeadLine();
    }


}
