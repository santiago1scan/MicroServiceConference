package co.edu.unicauca.microserviceconference.presentation.controlleres;


import co.edu.unicauca.microserviceconference.aplication.ConferenceService;
import co.edu.unicauca.microserviceconference.presentation.dto.ConferenceDTO;
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
    public ResponseEntity<Object> createConference(@RequestBody ConferenceDTO conferenceDTO) {
        if(conferenceDTO.getArticle() == null)
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Article cant be empty");
        if(conferenceDTO.getDate() == null)
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Date is needed");
        if(conferenceDTO.getTopics().isEmpty())
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("topic is needed");
        if(conferenceDTO.getPlace().isEmpty())
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("The place is needed");
        if(conferenceDTO.getBasicInfo().isEmpty())
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("The basic info is needed");
        if(conferenceDTO.getAuthor() == null)
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("author is needed");
        if(conferenceDTO.getOrganizer() == null)
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Organizer is required");


        ConferenceDTO createdUser = conferenceService.save(conferenceDTO);
        if(createdUser == null)
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Sorry, some issue creating user");
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }
    @GetMapping
    public ConferenceDTO findConerenceById(@PathVariable String id) {
        if (id.isEmpty())
            return null;
        ConferenceDTO conferenceDTO = conferenceService.findConferenceById(id);
        return conferenceDTO;
    }
    @PutMapping
    public ConferenceDTO updateConference(@PathVariable String id,@RequestBody ConferenceDTO conferenceDTO) {
        if(conferenceService.findConferenceById(id)  == null)
            return null;
        ConferenceDTO conferenceUpdateDTO = conferenceService.updateConference(id, conferenceDTO);
        return conferenceUpdateDTO;
    }
    @DeleteMapping
    public ConferenceDTO deleteConference(@PathVariable String id) {
        if(conferenceService.findConferenceById(id)  == null)
            return null;
        return  conferenceService.deleteConference(id);
    }


}
