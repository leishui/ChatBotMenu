import java.util.Scanner;

/**
 * 简单使用demo
 */
public class Main {
    public static void main(String[] args) {
        //初始化菜单
        CBMenus menus = initMenus();
        //[可选]设置menu内容输出方式 默认将菜单内容输出到控制台
        menus.setShow(cbMenu -> System.out.println("---------\n" + cbMenu.getContent() + "\n---------"));
        Scanner scanner = new Scanner(System.in);
        String t = "";
        //输出一下主菜单用
        menus.run(t);
        //输入q退出
        while (!(t = scanner.next()).equals("q")) {
            menus.run(t);
        }
    }

    private static CBMenus initMenus() {
        CBMenus menus = new CBMenus();
        CBMsg msg = new CBMsg();
        CBMenu menu0 = new CBMenu(0L,
                "main menu:\n" +
                        "1->1st\n" +
                        "2->2nd\n" +
                        "3->test") {
            @Override
            public CBMsg run(String para) {
                if (para.equals("1"))
                    msg.next(1);
                if (para.equals("2"))
                    msg.next(2);
                if (para.equals("3"))
                    msg.next(3);
                return msg;
            }

        };
        CBMenu menu1 = new CBMenu(1L,
                "1st:\n" +
                        "1->101\n" +
                        "2->102\n" +
                        "3->103") {
            @Override
            public CBMsg run(String para) {
                switch (para) {
                    case "1":
                        msg.next(1);
                        break;
                    case "2":
                        msg.next(2);
                        break;
                    case "3":
                        msg.next(3);
                        break;
                    case "0":
                        msg.back();
                        break;
                    case "00":
                        msg.home();
                        break;
                    default:
                        msg.no();
                }
                return msg;
            }
        };
        CBMenu menu2 = new CBMenu(2L,
                "2nd:\n" +
                        "1->201\n" +
                        "2->202\n" +
                        "3->203") {
            @Override
            public CBMsg run(String para) {
                switch (para) {
                    case "1":
                        msg.next(1);
                        break;
                    case "2":
                        msg.next(2);
                        break;
                    case "3":
                        msg.next(3);
                        break;
                    case "0":
                        msg.back();
                        break;
                    case "00":
                        msg.home();
                        break;
                    default:
                        msg.no();
                }
                return msg;
            }
        };
        CBMenu menu101 = new CBMenu(101L, "[101]") {
            @Override
            public CBMsg run(String para) {
                return getCbMsg(para, msg);
            }
        };
        CBMenu menu102 = new CBMenu(102L, "[102]") {
            @Override
            public CBMsg run(String para) {
                return getCbMsg(para, msg);
            }
        };
        CBMenu menu103 = new CBMenu(103L, "[103]") {
            @Override
            public CBMsg run(String para) {
                return getCbMsg(para, msg);
            }
        };
        CBMenu menu201 = new CBMenu(201L, "[201]") {
            @Override
            public CBMsg run(String para) {
                return getCbMsg(para, msg);
            }
        };
        CBMenu menu202 = new CBMenu(202L, "[202]") {
            @Override
            public CBMsg run(String para) {
                return getCbMsg(para, msg);
            }
        };
        CBMenu menu203 = new CBMenu(203L, "[203]") {
            @Override
            public CBMsg run(String para) {
                return getCbMsg(para, msg);
            }
        };
        CBMenu menu3 = new CBMenu(3L, "type: hhh") {
            @Override
            public CBMsg run(String para) {
                if (para.equals("hhh")) {
                    System.out.println("hhh");
                    msg.home();
                } else
                    msg.no();
                return msg;
            }
        };
        menus.addMenus(new CBMenu[]{menu0, menu1, menu2, menu101, menu102, menu103, menu201, menu202, menu203, menu3});
        return menus;
    }

    private static CBMsg getCbMsg(String para, CBMsg msg) {
        switch (para) {
            case "0":
                msg.back();
                break;
            case "00":
                msg.home();
                break;
            default:
                msg.no();
        }
        return msg;
    }
}
