package soft.hnron.winepiano

import android.media.MediaPlayer
import android.net.Uri
import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class MainActivityFragment : Fragment() {

    private var mPlayer = MediaPlayer()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mPlayer.setDataSource(context, Uri.parse("android.resource://soft.hnron.winepiano/raw/bgm"))
        mPlayer.prepare()
        mPlayer.isLooping = true
        mPlayer.start()
    }

    override fun onPause() {
        super.onPause()

        mPlayer.pause()
    }

    override fun onResume() {
        super.onResume()

        mPlayer.start()
    }
}
