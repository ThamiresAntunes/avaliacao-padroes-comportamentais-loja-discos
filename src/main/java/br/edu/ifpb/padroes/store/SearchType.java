package br.edu.ifpb.padroes.store;

public enum SearchType {
    TITLE(new TitleSearchStrategy()),
    ARTIST(new ArtistSearchStrategy()),
    GENRE(new GenreSearchStrategy()),
    TYPE(new TypeSearchStrategy());

    private final SearchStrategy strategy;

    SearchType(SearchStrategy strategy) {
        this.strategy = strategy;
    }

    public SearchStrategy getStrategy() {
        return strategy;
    }
}
