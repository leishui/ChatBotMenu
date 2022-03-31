/**
 * 层级跳转标志
 */
object CBChangeType {
    //返回上一级
    const val BACK = -1
    //返回主菜单
    const val HOME = 0
    //什么都不做
    const val NULL = -2
    //跳到下一级
    const val NEXT = -3
}