package br.edu.ifpb.padroes.store;

import br.edu.ifpb.padroes.music.AgeRestriction;
import br.edu.ifpb.padroes.music.Album;
import br.edu.ifpb.padroes.music.MediaType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchTest {
    private MusicStore storeTest;

    @BeforeEach
    void setUp() {
        storeTest = new MusicStore();

        storeTest.addMusic(new Album(
                "Nevermind", "Nirvana", MediaType.CD,
                50.0, LocalDate.of(1991, 9, 24),
                AgeRestriction.GENERAL, "Rock", 10
        ));

        storeTest.addMusic(new Album(
                "In Utero", "Nirvana", MediaType.VINYL,
                90.0, LocalDate.of(1993, 9, 21),
                AgeRestriction.GENERAL, "Rock", 5
        ));

        storeTest.addMusic(new Album(
                "Random Access Memories", "Daft Punk", MediaType.TAPE,
                60.0, LocalDate.of(2013, 5, 17),
                AgeRestriction.GENERAL, "Electronic", 8
        ));

        storeTest.addMusic(new Album(
                "The College Dropout", "Kanye West", MediaType.CD,
                40.0, LocalDate.of(2004, 2, 10),
                AgeRestriction.GENERAL, "Rap", 6
        ));
    }


    // ------------------------------------------------------------
    @Test
    @DisplayName("Should find albums by Title")
    void testSearchByTitle() {
        List<Album> result = storeTest.searchMusic(SearchType.TITLE, "Nevermind");

        assertEquals(1, result.size());
        assertEquals("Nevermind", result.get(0).getTitle());
    }

    // ------------------------------------------------------------
    @Test
    @DisplayName("Should find albums by Artist")
    void testSearchByArtist() {
        List<Album> result = storeTest.searchMusic(SearchType.ARTIST, "Nirvana");

        assertEquals(2, result.size(), "Should return all Nirvana albums");
    }

    // ------------------------------------------------------------
    @Test
    @DisplayName("Should find albums by Genre")
    void testSearchByGenre() {
        List<Album> result = storeTest.searchMusic(SearchType.GENRE, "Electronic");

        assertEquals(1, result.size());
        assertEquals("Random Access Memories", result.get(0).getTitle());
    }

    // ------------------------------------------------------------
    @Test
    @DisplayName("Should find albums by Type (MediaType)")
    void testSearchByType() {
        List<Album> result = storeTest.searchMusic(SearchType.TYPE, "CD");

        assertEquals(2, result.size(), "Should find all albums that are CD");
    }
}
