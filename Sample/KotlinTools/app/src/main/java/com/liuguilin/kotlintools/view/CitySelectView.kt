package com.liuguilin.kotlintools.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.TextView
import com.liuguilin.okhelper.utils.L


/**
 * FileName: CitySelectView
 * Founder: LiuGuiLin
 * Profile: 城市选择View
 */
class CitySelectView : View {

    //view的宽度
    private var viewWidth = 0
    //view的高度
    private var viewHeight = 0

    //数据集
    private var list: List<String>? = null

    //子Item高度
    private var itemHeight = 0

    //选中的下标
    private var checkIndex = 0

    //选中的文本大小
    private val checkTextSize = 40f
    //没选中的文本大小
    private val unCheckTextSize = 30f

    //要显示的View
    private var showCityView: TextView? = null

    //画笔
    private val mPaint by lazy { Paint() }

    constructor(context: Context?) : super(context) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        viewWidth = w
        viewHeight = h
    }

    private fun init() {
        //抗锯齿
        mPaint.isAntiAlias = true
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        list?.let {
            itemHeight = viewHeight / it.size
            //每一次选中
            for ((index, text) in it.withIndex()) {
                if (index == checkIndex) {
                    mPaint.color = Color.RED
                    mPaint.textSize = checkTextSize
                } else {
                    mPaint.color = Color.BLACK
                    mPaint.textSize = unCheckTextSize
                }
                val x = (viewWidth - mPaint.measureText(text)) / 2
                val y = (itemHeight * index + itemHeight).toFloat()
                canvas?.drawText(text, x, y, mPaint)
            }
        }
    }

    fun setCity(list: List<String>) {
        L.i("list siz : ${list.size}")
        this.list = list
        invalidate()
    }

    fun setItemCity(city: String) {
        checkIndex = list?.indexOf(city)!!
        invalidate()
    }

    fun setShowView(textView: TextView) {
        this.showCityView = textView
        this.showCityView?.visibility = GONE
    }

    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                this.showCityView?.visibility = VISIBLE
            }
            MotionEvent.ACTION_MOVE -> {
                //计算你选中的值
                list?.let {
                    val oldCheckIndex = checkIndex
                    val c = (event.y / viewHeight * it.size)
                    if (oldCheckIndex != c.toInt()) {
                        if (c > 0 && c < it.size) {
                            listener?.let { ll ->
                                ll(it[c.toInt()])
                            }
                        }
                    }
                    checkIndex = c.toInt()
                    invalidate()
                }
            }
            MotionEvent.ACTION_UP -> {
                this.showCityView?.visibility = GONE
            }
        }
        return super.dispatchTouchEvent(event)
    }

    private var listener: ((text: String) -> Unit)? = null

    fun setOnMoveItemListener(listener: ((text: String) -> Unit)) {
        this.listener = listener
    }
}