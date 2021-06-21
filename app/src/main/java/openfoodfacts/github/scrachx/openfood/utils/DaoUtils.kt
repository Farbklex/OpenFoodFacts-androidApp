package openfoodfacts.github.scrachx.openfood.utils

import android.util.Log
import androidx.annotation.CheckResult
import io.reactivex.Single
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import openfoodfacts.github.scrachx.openfood.repositories.Taxonomy
import org.greenrobot.greendao.AbstractDao
import org.jetbrains.annotations.Contract

/**
 * Checks whether table is empty
 */
@Contract(pure = true)
@CheckResult
suspend fun AbstractDao<*, *>.isEmpty() = withContext(Dispatchers.IO) { this@isEmpty.count() == 0L }

@Contract(pure = true)
@CheckResult
fun <T> logDownload(single: Single<List<T>?>, taxonomy: Taxonomy) = single.doOnSuccess {
    Log.i(Taxonomy::class.simpleName + "getTaxonomyData", "refreshed taxonomy '$taxonomy' from server")
}