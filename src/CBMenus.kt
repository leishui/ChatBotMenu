//用于对所有menu进行管理
class CBMenus() {

    //初始化一个将菜单内容输出到控制台的show
    var show: Show = object : Show {
        override fun show(cbMenu: CBMenu) {
            println(cbMenu.content)
        }
    }
    //初始化menu集
    private val menus: HashMap<Long, CBMenu> = HashMap()
    //初始位置为主菜单
    var position = 0L

    //用于设置菜单内容输出方式
    interface Show {
        /**
         * 设置菜单内容输出方式
         * @param cbMenu CBMenu
         */
        fun show(cbMenu: CBMenu)
    }

    /**
     * 添加一个菜单
     * @param cbMenu CBMenu
     */
    fun addMenu(cbMenu: CBMenu) {
        menus[cbMenu.position] = cbMenu
    }

    /**
     * 添加多个菜单
     * @param cbMenus Array<CBMenu> 菜单集
     */
    fun addMenus(cbMenus: Array<CBMenu>) {
        for (menu in cbMenus) {
            menus[menu.position] = menu
        }
    }

    /**
     * 用于进行层级转换
     * @param changeType Int
     * @param nextPosition Int
     */
    private fun changePosition(changeType: Int, nextPosition: Int) {
        //val oldPos = position//用于出错后还原
        //判断层级是否要进行跳转
        when (changeType) {
            CBChangeType.BACK -> {
                position /= 100 //层级减
            }
            CBChangeType.NEXT -> {
                position = position * 100 + nextPosition //层级加
            }
            CBChangeType.HOME -> {
                position = 0L
            }
            else -> {
                //可选择不输出菜单
                if (nextPosition == 1) return
            }
        }
        menus[position]?.let {
            show.show(it)
            return
        } //发送新层级菜单内容
        //出错，找不到对应menu，进行还原
        throw Exception("The target menu could not be found\n所要跳转的菜单不存在")
        //position = oldPos
        //menus[oldPos]?.let { show.show(it) }
    }

    fun run(content: String) {
        val menu = menus[position]
        menu?.let {
            val msg: CBMsg = it.run(content)!!
            changePosition(msg.getChangeType(), msg.getNextPosition())
        }
    }
}