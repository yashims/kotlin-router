package me.yashims85.korouter

data class Route(
    val path: String,
    val name: String?,
    val component: Presenter,
    var children: List<Route>? = null,
    var parent: Route? = null
) {
    fun fullPath(): String {
        return parent?.let {
            val fullPath = it.fullPath()
            if (fullPath.isBlank()) path else "$fullPath/$path"
        } ?: path
    }
}