package src.shapes;

public abstract class ShapeDefinition {
    private static final boolean[][] SHAPE_I = {{true, false, false, false},
                                                {true, false, false, false},
                                                {true, false, false, false},
                                                {true, false, false, false}};
    private static final boolean[][] SHAPE_J = {{false, false, true},
                                                 {false, false, true},
                                                 {false, true, true}};
    private static final boolean[][] SHAPE_T = {{true, true, true},
                                                {false, true, false},
                                                {false, false, false}};
    private static final boolean[][] SHAPE_S = {{false, true, true},
                                                {true, true, false},
                                                {false, false, false}};
    private static final boolean[][] SHAPE_Z = {{true, true, false},
                                                {false, true, true},
                                                {false, false, false}};
    private static final boolean[][] SHAPE_L = {{true, false, false},
                                                {true, false, false},
                                                {true, true, false}};
    private static final boolean[][] SHAPE_O = {{true, true},
                                                {true, true}};

   public static boolean[][] generate(final ShapeType type) {
       switch (type) {
           case I:
               return SHAPE_I;
           case T:
               return SHAPE_T;
           case L:
               return SHAPE_L;
           case J:
               return SHAPE_J;
           case S:
               return SHAPE_S;
           case Z:
               return SHAPE_Z;
           default:
               return SHAPE_O;
       }
    }
}
