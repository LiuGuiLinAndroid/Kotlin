package com.liuguilin.kotlinweather.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.TextView
import com.liuguilin.kotlinweather.utils.L


/**
 * FileName: CitySelectView
 * Founder: LiuGuiLin
 * Profile:
 */
class CitySelectView : View {

    //View的宽度
    private var viewWidth: Int = 0
    //View的高度
    private var viewHeight: Int = 0
    //数据集
    private var list: List<String>? = null
    //列表高度
    private var itemHeight: Int = 0
    //选中的下标
    private var checkIndex: Int = 0

    //选中文字大小
    private val checkTextSize = 40f
    //未选中文字大小
    private val unCheckTextSize = 30f

    //显示的TextView
    private var showCityView: TextView? = null
    //画笔
    private val mPaint: Paint by lazy { Paint() }

    constructor(context: Context?) : super(context) {
        initPaint()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        initPaint()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        initPaint()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        viewWidth = w
        viewHeight = h
        super.onSizeChanged(w, h, oldw, oldh)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvasCityName(canvas)
    }

    private fun initPaint() {
        mPaint.isAntiAlias = true
    }

    //绘制城市名称
    private fun canvasCityName(canvas: Canvas?) {
        list?.let {
            itemHeight = viewHeight / it.size
            for ((index, text) in it.withIndex()) {
                if (index == checkIndex) {
                    mPaint.color = Color.RED
                    mPaint.textSize = checkTextSize
                } else {
                    mPaint.color = Color.BLACK
                    mPaint.textSize = unCheckTextSize

                }
                val lettersX: Float = (viewWidth - mPaint.measureText(text)) / 2
                val lettersY: Float = (itemHeight * index + itemHeight).toFloat()
                canvas?.drawText(text, lettersX, lettersY, mPaint)
            }
        }
    }

    //设置城市列表
    fun setCity(list: List<String>) {
        this.list = list
        invalidate()
    }

    //设置显示的View
    fun setShowView(view: TextView) {
        this.showCityView = view
        this.showCityView?.visibility = GONE
    }

    fun setItemCity(city: String) {
        list?.let {
            checkIndex = it.indexOf(city)
            L.i("checkIndex $checkIndex")
            invalidate()
        }
    }

    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN, MotionEvent.ACTION_MOVE -> {
                //计算选中的字母
                list?.let {
                    //获取选中的坐标
                    val oldCheckIndex = checkIndex
                    val c = (event.y / viewHeight * it.size)
                    if (oldCheckIndex != c.toInt()) {
                        if (c >= 0 && c < it.size) {
                            listener!!(it[c.toInt()])
                            showCityView?.visibility = visibility
                        }
                    }
                    checkIndex = c.toInt()
                    invalidate()
                }
            }
            MotionEvent.ACTION_UP -> {
                showCityView?.visibility = GONE
            }
        }
        return true
    }

    //对外的数据接口
    private var listener: ((text: String) -> Unit)? = null

    fun setOnMoveItemListener(listener: ((text: String) -> Unit)) {
        this.listener = listener
    }
}