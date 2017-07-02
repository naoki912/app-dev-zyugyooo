package soft.hnron.vesekentei

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class KenteiFragment : Fragment() {

    private var mListener: KenteiFragmentListener? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_kentei, container, false)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is KenteiFragmentListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement KenteiFragmentListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    interface KenteiFragmentListener { }

    companion object {
        fun newInstance(): KenteiFragment = KenteiFragment()
        val TAG = "KenteiFragment"
    }
}
