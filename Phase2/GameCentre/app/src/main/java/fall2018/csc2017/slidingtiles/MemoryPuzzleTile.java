package fall2018.csc2017.slidingtiles;


import android.support.annotation.NonNull;

import java.io.Serializable;

public class MemoryPuzzleTile implements Comparable<MemoryPuzzleTile>, Serializable {

    /**
     * The background id to find the tile image.
     */
    private int background;

    /**
     * The unique id.
     */
    private int id;

    /**
     * Return the background id.
     *
     * @return the background id
     */
    public int getBackground() {
        return background;
    }

    /**
     * Return the tile id.
     *
     * @return the tile id
     */
    public int getId() {
        return id;
    }

    /**
     * set the id of the memory puzzle tile
     *
     * @param id the new id of the tile
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * A MemoryPuzzleTile with id and background. The background may not have a corresponding image.
     *
     * @param id         the id
     * @param background the background
     */
    MemoryPuzzleTile(int id, int background) {
        this.id = id;
        this.background = background;
    }


    //TODO: fix this

    /**
     * A Memory Puzzle tile with a background id; look up and set the id.
     *
     * @param backgroundId the background id of the tile
     */
    MemoryPuzzleTile(int backgroundId) {
        id = backgroundId + 1;
        // This looks so ugly.
        switch (backgroundId + 1) {
            case 1:
                background = R.drawable.memory_tile_1;
                break;
            case 2:
                background = R.drawable.memory_tile_2;
                break;
            case 3:
                background = R.drawable.memory_tile_3;
                break;
            case 4:
                background = R.drawable.memory_tile_4;
                break;
            case 5:
                background = R.drawable.memory_tile_5;
                break;
            case 6:
                background = R.drawable.memory_tile_6;
                break;
            case 7:
                background = R.drawable.memory_tile_7;
                break;
            case 8:
                background = R.drawable.memory_tile_8;
                break;
            case 9:
                background = R.drawable.memory_tile_9;
                break;
            case 10:
                background = R.drawable.memory_tile_10;
                break;
            case 11:
                background = R.drawable.memory_tile_11;
                break;
            case 12:
                background = R.drawable.memory_tile_12;
                break;
            case 13:
                background = R.drawable.memory_tile_13;
                break;
            case 14:
                background = R.drawable.memory_tile_14;
                break;
            case 15:
                background = R.drawable.memory_tile_15;
                break;
            case 16:
                background = R.drawable.memory_tile_16;
                break;
            case 17:
                background = R.drawable.memory_tile_17;
                break;
            case 18:
                background = R.drawable.memory_tile_18;
                break;
            case 19:
                background = R.drawable.memory_tile_19;
                break;
            case 20:
                background = R.drawable.memory_tile_20;
                break;
            case 21:
                background = R.drawable.memory_tile_21;
                break;
            case 22:
                background = R.drawable.memory_tile_22;
                break;
            case 23:
                background = R.drawable.memory_tile_23;
                break;
            case 24:
                background = R.drawable.memory_tile_24;
                break;
            case 25:
                background = R.drawable.memory_tile_25;
                break;
            case 26:
                background = R.drawable.memory_tile_26;
                break;
            case 27:
                background = R.drawable.memory_tile_27;
                break;
            case 28:
                background = R.drawable.memory_tile_28;
                break;
            case 29:
                background = R.drawable.memory_tile_29;
                break;
            case 30:
                background = R.drawable.memory_tile_30;
                break;
            case 31:
                background = R.drawable.memory_tile_31;
                break;
            case 32:
                background = R.drawable.memory_tile_32;
                break;
            case 33:
                background = R.drawable.memory_tile_33;
                break;
            case 34:
                background = R.drawable.memory_tile_34;
                break;
            case 35:
                background = R.drawable.memory_tile_35;
                break;
            case 36:
                background = R.drawable.memory_tile_36;
                break;
            case 38:
                background = R.drawable.memory_tile_38;
                break;
            default:
                background = R.drawable.tile_blank;
        }
    }

//    /**
//     * A Memory Puzzle tile with a background id, set the id eaquals to the backgroundid
//     *
//     * @param backgroundId the background id of the tile
//     */
//    MemoryPuzzleTile(int backgroundId) {
//        id = backgroundId;
//        String fileName = "memory_tile_" + backgroundId;
//        background = App.getContext().getResources().getIdentifier(
//                fileName, "drawable", "fall2018.csc2017.slidingtiles");
//    }
//
//    public static void main(String[] args) {
//        MemoryPuzzleTile memo = new MemoryPuzzleTile(1);
//        memo.getBackground();

    @Override
    public int compareTo(@NonNull MemoryPuzzleTile o) {
        //TODO
        return 0;
    }
    }

