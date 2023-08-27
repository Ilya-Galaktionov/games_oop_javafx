package ru.job4j.chess;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LogicTest {

    @Test
    void whenMoveThenFigureNotFoundException()
            throws ImpossibleMoveException {
        Logic logic = new Logic();
        FigureNotFoundException exception = assertThrows(FigureNotFoundException.class, () -> {
            logic.move(Cell.C1, Cell.H6);
        });
        assertThat(exception.getMessage()).isEqualTo("Figure not found on the board.");
    }

    @Test
    void whenMoveOccupiedThenOccupiedCellException() {
        Logic logic = new Logic();
        Figure figure = new BishopBlack(Cell.A1);
        Figure figure1 = new BishopBlack(Cell.C3);
        logic.add(figure);
        logic.add(figure1);
        OccupiedCellException exception = assertThrows(OccupiedCellException.class, () -> {
            logic.move(Cell.A1, Cell.C3);
        });
        assertThat(exception.getMessage()).isEqualTo("Occupied cell on the way");
    }

    @Test
    void whenMoveThenImpossibleMoveException() {
        Logic logic = new Logic();
        Cell start = Cell.A1;
        Cell dest = Cell.D5;
        Figure figure = new BishopBlack(start);
        logic.add(figure);
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class, () -> {
            logic.move(start, dest);
        });
        assertThat(exception.getMessage()).isEqualTo(
                "Could not move by diagonal from %s to %s", start, dest
        );
    }
}