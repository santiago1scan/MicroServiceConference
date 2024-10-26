package co.edu.unicauca.microserviceconference.aplication;

import co.edu.unicauca.microserviceconference.domain.interfaces.IAuthorRepository;
import co.edu.unicauca.microserviceconference.domain.interfaces.IConferencesRepository;
import co.edu.unicauca.microserviceconference.domain.model.Author;
import co.edu.unicauca.microserviceconference.presentation.dto.AuthorDTO;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthorServices {
    @Autowired
    private IAuthorRepository repository;

    private IConferencesRepository conferencesRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public AuthorServices(IAuthorRepository repository, IConferencesRepository conferencesRepository) {
        this.repository = repository;
        this.conferencesRepository = conferencesRepository;
        this.modelMapper = new ModelMapper();
    }

    /**
     *
     * @brief find the author by id
     * @param id id of Auhthor to find
     * @return AUTHORDTO
     */
    public AuthorDTO findBiId(String id){
        if(id == null)
            return null;
        Author authorFind= this.repository.findById(id);
        if(authorFind != null)
            return this.modelMapper.map(authorFind, AuthorDTO.class);
        return null;
    }

    /**
     * @brief save Author in a confernce
     * @param authorToSave class DTO author to save
     * @return Author save or null
     */
    public AuthorDTO save(AuthorDTO authorToSave){
        if(authorToSave.getId().isEmpty())
            return null;
        if(authorToSave.getName().isEmpty())
            return null;
        if(authorToSave.getEmail().isEmpty())
            return null;
        if(repository.saveAuthor(this.modelMapper.map(authorToSave, Author.class)) == null)
            return null;
        return authorToSave;
    }



    /**
     * @brief delte Author
     * @param id id of Author to delete
     * @return Author delete or null1
     */
    public AuthorDTO deleteById(String id){
        AuthorDTO author = modelMapper.map(this.repository.findById(id), AuthorDTO.class) ;
        return modelMapper.map( repository.deleteAuthor(id), AuthorDTO.class) ;
    }




}
