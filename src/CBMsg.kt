/**
 * 包含各种跳转信息
 * @property changeType Int 跳转类型
 * @property nextPosition Int 所要跳转的下一层中的位置
 */
class CBMsg() {
    private var changeType: Int
    private var nextPosition: Int

    init {
        //默认留在本层不进行跳转
        this.changeType = CBChangeType.NULL
        this.nextPosition = 0
    }

    /**
     * 获取跳转类型
     * @return Int [CBChangeType]中的类型
     */
    fun getChangeType(): Int {
        return changeType
    }

    /**
     * 获取跳转到下一层的哪个位置
     * @return Int 跳转到下一层的位置
     */
    fun getNextPosition(): Int {
        return nextPosition
    }

    /**
     * 跳转到下一层
     * @param position Int 下一层中的位置
     */
    fun next(position: Int) {
        changeType = CBChangeType.NEXT
        nextPosition = position
    }

    /**
     * 返回主菜单
     */
    fun home() {
        changeType = CBChangeType.HOME
    }

    /**
     * 返回上一层
     */
    fun back() {
        changeType = CBChangeType.BACK
    }

    /**
     * 不做跳转，且不输出菜单内容
     */
    fun no() {
        nextPosition = 1//不输出菜单
        changeType = CBChangeType.NULL
    }

    /**
     * 不做跳转，并设置是否需要输出菜单内容
     * @param needShow Boolean 是否需要输出菜单内容
     */
    fun no(needShow: Boolean) {
        nextPosition = if (needShow) 0 else 1
        changeType = CBChangeType.NULL
    }
}