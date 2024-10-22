package co.edu.unicauca.microserviceconference.presentation.controlleres;


import co.edu.unicauca.microserviceconference.aplication.ConferenceService;
import co.edu.unicauca.microserviceconference.presentation.dto.ConferenceInDTO;
import co.edu.unicauca.microserviceconference.presentation.dto.ConferenceOutDTO;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ConferenceController {
    @Autowired
    private ConferenceService conferenceService;

    @PostMapping("/conference")
    public ResponseEntity<Object> createConference(@RequestBody ConferenceInDTO conferenceDTO) {
        if(conferenceDTO.getStartDate() == null )
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Start Date is needed");
        if(conferenceDTO.getFinishDate() == null)
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Finish Date is needed");
        if(conferenceDTO.getTopic() == null || conferenceDTO.getTopic().isEmpty())
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("topic is needed");
        if(conferenceDTO.getPlace() == null || conferenceDTO.getPlace().isEmpty())
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("The place is needed");
        if(conferenceDTO.getIdOrganizer() == null || conferenceDTO.getIdOrganizer().isEmpty())
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Organizer is required");


        ConferenceOutDTO   createdUser = conferenceService.save(conferenceDTO);
        if(createdUser == null)
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Sorry, some issue creating user");
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }
    @GetMapping()
    public ResponseEntity<ConferenceOutDTO> findConerenceById(@PathVariable String id) {
        if (id.isEmpty())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        ConferenceOutDTO conferenceDTO = conferenceService.findConferenceById(id);
        return ResponseEntity.status(HttpStatus.OK).body(conferenceDTO);
    }
    @PutMapping("/conference/{id}")
    public ResponseEntity<ConferenceOutDTO> updateConference(@PathVariable String id, @RequestBody ConferenceInDTO conferenceDTO) {
        if(conferenceService.findConferenceById(id)  == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        ConferenceOutDTO conferenceUpdateDTO = conferenceService.updateConference(id, conferenceDTO);
        return ResponseEntity.status(HttpStatus.OK).body(conferenceUpdateDTO);
    }
    @DeleteMapping("/conference/id/{id}")
    public ResponseEntity<ConferenceOutDTO> deleteConference(@PathVariable String id) {
        if(conferenceService.findConferenceById(id)  == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.status(HttpStatus.OK).body(conferenceService.deleteConference(id));
    }


}
