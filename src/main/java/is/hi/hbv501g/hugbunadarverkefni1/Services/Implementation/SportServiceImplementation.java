package is.hi.hbv501g.hugbunadarverkefni1.Services.Implementation;

import is.hi.hbv501g.hugbunadarverkefni1.Persistence.Entities.Club;
import is.hi.hbv501g.hugbunadarverkefni1.Persistence.Entities.Event;
import is.hi.hbv501g.hugbunadarverkefni1.Persistence.Entities.Player;
import is.hi.hbv501g.hugbunadarverkefni1.Persistence.Repositories.ClubRepository;
import is.hi.hbv501g.hugbunadarverkefni1.Persistence.Repositories.EventRepository;
import is.hi.hbv501g.hugbunadarverkefni1.Persistence.Repositories.PlayerRepository;
import is.hi.hbv501g.hugbunadarverkefni1.Services.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class SportServiceImplementation implements SportService {

    private PlayerRepository playerRepository;
    private EventRepository eventRepository;
    private ClubRepository clubRepository;

    @Autowired
    public SportServiceImplementation(PlayerRepository playerRepository, EventRepository eventRepository, ClubRepository clubRepository) {
        this.playerRepository = playerRepository;
        this.clubRepository = clubRepository;
        this.eventRepository = eventRepository;
    }




    @Override
    public List<String> findAllSports() {
        List<String> sport = new ArrayList<String>();
        sport.add("badminton");
        sport.add("pilukast");
        sport.add("Extreme Ironing");
        return sport;
    }

    public  Boolean isSport(String sport){
        return findAllSports().contains(sport);
    }


    //------------------------CLUB START----------------------------------------------
    @Override
    public List<Club> findAllClubsBySport(String sport) {
        return clubRepository.findBySport(sport);
    }

    @Override
    public Club saveClub(Club club) {
        return clubRepository.save(club);
    }

    @Override
    public void deletClubById(long id) {
        clubRepository.delete(clubRepository.findByID(id));
    }
    //------------------------CLUB END----------------------------------------------


    //------------------------EVENT START----------------------------------------------
    @Override
    public List<Event> findAllEventsBySport(String sport) {
        return eventRepository.findBySport(sport);
    }

    @Override
    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public void deletEventById(long id) {
        eventRepository.delete(eventRepository.findByID(id));
    }
    //------------------------EVENT END----------------------------------------------


    //------------------------PLAYER START----------------------------------------------
    @Override
    public List<Player> findAllPlayersBySport(String sport) {
        return playerRepository.findBySport(sport);
    }

    @Override
    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public void deletPlayerById(long id) {
        playerRepository.delete(playerRepository.findByID(id));
    }
    //------------------------PLAYER END----------------------------------------------


}
