/**
 * 一个普通的菜单类
 * @property position Long 菜单所在层级位置
 * @property content String 菜单内容
 * @property cbMsg CBMsg
 * @constructor
 */
open class CBMenu(val position: Long, open var content: String) {
    @JvmField val cbMsg = CBMsg()

    /**
     * 处理输入参数，定义后续操作
     * @param para String 传入菜单的参数
     * @return CBMsg?
     */
    open fun run(para: String): CBMsg? {
        return cbMsg
    }
}