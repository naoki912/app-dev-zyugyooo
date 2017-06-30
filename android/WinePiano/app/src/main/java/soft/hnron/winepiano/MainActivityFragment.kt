package soft.hnron.winepiano

import android.media.MediaPlayer
import android.net.Uri
import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.ScaleAnimation
import android.widget.ImageButton
import android.support.v4.content.res.ResourcesCompat
import android.view.animation.RotateAnimation
import android.view.animation.TranslateAnimation

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

        val wineImage = ResourcesCompat.getDrawable(resources, R.drawable.wine, null)!!

        val rotateAnimation = RotateAnimation(
                0f,
                360f,
                wineImage.intrinsicWidth.toFloat() / 2,
                wineImage.intrinsicHeight.toFloat() / 2
        )
        rotateAnimation.duration = 500

        val translateAnimation = TranslateAnimation(0f, 0f, 0f, -100f)
        translateAnimation.duration = 500

        val scaleUpAnimation = ScaleAnimation(1.0f, 1.5f, 1.0f, 1.5f)
        scaleUpAnimation.duration = 500

        val scaleDownAnimation = ScaleAnimation(1.0f, 0.5f, 1.0f, 0.5f)
        scaleDownAnimation.duration = 500

        bottomRightGlassButton?.setOnClickListener {
            playGlassSound("android.resource://soft.hnron.winepiano/raw/bottom_right")
            // 反転
        }

        bottomCenterGlassButton?.setOnClickListener {
            playGlassSound("android.resource://soft.hnron.winepiano/raw/bottom_center")
            bottomCenterGlassButton.startAnimation(rotateAnimation)
        }

        bottomLeftGlassButton?.setOnClickListener {
            playGlassSound("android.resource://soft.hnron.winepiano/raw/bottom_left")
            bottomLeftGlassButton.startAnimation(translateAnimation)
        }

        upperRightGlassButton?.setOnClickListener {
            playGlassSound("android.resource://soft.hnron.winepiano/raw/upper_right")
            upperRightGlassButton.startAnimation(scaleDownAnimation)
        }

        upperLeftGlassButton?.setOnClickListener {
            playGlassSound("android.resource://soft.hnron.winepiano/raw/upper_left")
            upperLeftGlassButton.startAnimation(scaleUpAnimation)
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
