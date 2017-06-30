package soft.hnron.winepiano

import android.media.MediaPlayer
import android.net.Uri
import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton

class MainActivityFragment : Fragment() {

    private var mBgmPlayer = MediaPlayer()
    private var mGlassPlayer = MediaPlayer()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBgmPlayer.setDataSource(context, Uri.parse("android.resource://soft.hnron.winepiano/raw/bgm"))
        mBgmPlayer.prepare()
        mBgmPlayer.isLooping = true
        mBgmPlayer.start()

        val bottomRightGlassButton = view?.findViewById<ImageButton>(R.id.bottom_right_glass_button)
        val bottomCenterGlassButton = view?.findViewById<ImageButton>(R.id.bottom_center_glass_button)
        val bottomLeftGlassButton = view?.findViewById<ImageButton>(R.id.bottom_left_glass_button)
        val upperRightGlassButton = view?.findViewById<ImageButton>(R.id.upper_right_glass_button)
        val upperLeftGlassButton = view?.findViewById<ImageButton>(R.id.upper_left_glass_button)

        val playGlassSound = {
            uri: String ->
            mGlassPlayer.reset()
            mGlassPlayer.setDataSource(context, Uri.parse(uri))
            mGlassPlayer.prepare()
            mGlassPlayer.start()
        }

        bottomRightGlassButton?.setOnClickListener {
            playGlassSound("android.resource://soft.hnron.winepiano/raw/bottom_right")
        }

        bottomCenterGlassButton?.setOnClickListener {
            playGlassSound("android.resource://soft.hnron.winepiano/raw/bottom_center")
        }

        bottomLeftGlassButton?.setOnClickListener {
            playGlassSound("android.resource://soft.hnron.winepiano/raw/bottom_left")
        }

        upperRightGlassButton?.setOnClickListener {
            playGlassSound("android.resource://soft.hnron.winepiano/raw/upper_right")
        }

        upperLeftGlassButton?.setOnClickListener {
            playGlassSound("android.resource://soft.hnron.winepiano/raw/upper_left")
        }
    }

    override fun onPause() {
        super.onPause()

        mBgmPlayer.pause()
        mGlassPlayer.stop()
    }

    override fun onResume() {
        super.onResume()

        mBgmPlayer.start()
    }
}
