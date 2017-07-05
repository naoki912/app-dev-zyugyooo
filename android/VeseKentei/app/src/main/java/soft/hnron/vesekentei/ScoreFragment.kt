package soft.hnron.vesekentei

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class ScoreFragment : Fragment() {

    private var mListener: ScoreFragmentListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_score, container, false)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is ScoreFragmentListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement ScoreFragmentListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    interface ScoreFragmentListener { }

    companion object {
        fun newInstance(): ScoreFragment = ScoreFragment()
        val TAG = "SongFragment"
    }
}
