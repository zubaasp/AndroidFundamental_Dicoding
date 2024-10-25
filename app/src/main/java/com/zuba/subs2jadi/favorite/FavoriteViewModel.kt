import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.zuba.subs2jadi.database.FavoriteUsers
import com.zuba.subs2jadi.database.FavoriteUsersDao
import com.zuba.subs2jadi.database.UserDatabase

class FavoriteViewModel (application: Application): AndroidViewModel(application) {

    private var userDao: FavoriteUsersDao?
    private var userDb: UserDatabase? = UserDatabase.getDatabase(application)

    init {
        userDao = userDb?.favoriteUserDao()
    }

    fun getFavoriteUser(): LiveData<List<FavoriteUsers>>? {
        return userDao?.getFavoriteUser()
    }
}