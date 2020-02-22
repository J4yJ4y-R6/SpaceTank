package name.panitz.game.framework;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumSet;

public enum KeyCode{
  LEFT_ARROW(37),
  RIGHT_ARROW(39),
  DOWN_ARROW(40),
  UP_ARROW(38),
  VK_A('A'),
  VK_B('B'),
  VK_C('C'),
  VK_D('D'),
  VK_E('E'),
  VK_F('F'),
  VK_G('G'),
  VK_H('H'),
  VK_I('I'),
  VK_J('J'),
  VK_K('K'),
  VK_L('L'),
  VK_M('M'),
  VK_N('N'),
  VK_O('O'),
  VK_P('P'),
  VK_Q('Q'),
  VK_R('R'),
  VK_S('S'),
  VK_T('T'),
  VK_U('U'),
  VK_V('V'),
  VK_W('W'),
  VK_X('X'),
  VK_Y('Y'),
  VK_Z('Z'),
  VK_SPACE(' ');

  private static final Map<Integer, KeyCode> LOOKUP
    = new HashMap<Integer,KeyCode>();

  static {
    for(KeyCode s : EnumSet.allOf(KeyCode.class))
      LOOKUP.put(s.getCode(), s);
  }

  private int code;
  private KeyCode(int code){
    this.code = code;
  }

  public int getCode() {
    return code;
  }

  public static KeyCode fromCode(int code) {
    return LOOKUP.get(code);
  }
}

