import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Bank {

    private final Map<UUID, Cell> cells = new HashMap<>();

    /**
     * Метод приваивает банковской ячейке уникальный ключ
     */
    public UUID createCell() {

        UUID key = UUID.randomUUID();
        createCell(key);

        return key;
    }

    /**
     * Метод нужен для передачи ячейки.
     * Если ячейка отсутствует, он ее создает.
     */
    public Cell getCell(UUID key) {
        if (key == null) throw new IllegalArgumentException("key must not be null!");

        Cell cell = this.cells.get(key);
        if (cell == null) {
            createCell(key);
        }
        return cells.get(key);
    }

    /**
     * Метод создает банковскую ячейку
     */
    private void createCell(UUID key) {
        this.cells.put(key, new Cell());
    }
}
