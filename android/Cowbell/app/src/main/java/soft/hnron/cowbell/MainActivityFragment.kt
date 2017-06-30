package soft.hnron.cowbell

import android.media.MediaPlayer
import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton

class MainActivityFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mediaPlayer = MediaPlayer.create(context, R.raw.cowbell)

        val imageButton = view?.findViewById<ImageButton>(R.id.imageButton)
        imageButton?.setOnClickListener {

            // 音楽ファイルの再生時間が2〜3秒ほどあるため、
            // 一度seekを0にしないと連打した時に音がならない
            if (mediaPlayer.isPlaying) {
                mediaPlayer.seekTo(0)
            }

            mediaPlayer.start()
        }
    }
}
