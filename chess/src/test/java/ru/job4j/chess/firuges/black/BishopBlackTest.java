package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.assertj.core.api.Assertions.*;

class BishopBlackTest {

    @Test
    void whenCorrectPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        Cell expected = Cell.C8;
        Cell actual = bishopBlack.position();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void whenCorrectReturnPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        Cell expected = Cell.C5;
        Figure actual = bishopBlack.copy(Cell.C5);
        assertThat(actual.position()).isEqualTo(expected);
    }

    @Test
    void whenCheckWay() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Cell[] actual = bishopBlack.way(Cell.G5);
        assertThat(expected).isEqualTo(actual);
    }
}