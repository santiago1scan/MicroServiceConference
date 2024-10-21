package co.edu.unicauca.microserviceconference.presentation.controlleres;


import co.edu.unicauca.microserviceconference.aplication.ConferenceService;
import co.edu.unicauca.microserviceconference.presentation.dto.ConferenceInDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/conference")
public class ConferenceController {
    @Autowired
    private ConferenceService conferenceService;

    @PostMapping
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


        ConferenceInDTO createdUser = conferenceService.save(conferenceDTO);
        if(createdUser == null)
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Sorry, some issue creating user");
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }
    @GetMapping
    public ConferenceInDTO findConerenceById(@PathVariable String id) {
        if (id.isEmpty())
            return null;
        ConferenceInDTO conferenceDTO = conferenceService.findConferenceById(id);
        return conferenceDTO;
    }
    @PutMapping
    public ConferenceInDTO updateConference(@PathVariable String id, @RequestBody ConferenceInDTO conferenceDTO) {
        if(conferenceService.findConferenceById(id)  == null)
            return null;
        ConferenceInDTO conferenceUpdateDTO = conferenceService.updateConference(id, conferenceDTO);
        return conferenceUpdateDTO;
    }
    @DeleteMapping
    public ConferenceInDTO deleteConference(@PathVariable String id) {
        if(conferenceService.findConferenceById(id)  == null)
            return null;
        return  conferenceService.deleteConference(id);
    }


}
