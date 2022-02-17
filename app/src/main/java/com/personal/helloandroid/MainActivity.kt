package com.personal.helloandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.personal.helloandroid.databinding.ActivityMainBinding
import com.personal.helloandroid.enums.CoursesEnum
import com.personal.helloandroid.model.CoursesModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val react = CoursesModel(CoursesEnum.REACT.title, CoursesEnum.REACT.url)
    private val kot = CoursesModel(CoursesEnum.KOTLIN.title, CoursesEnum.KOTLIN.url)
    var current = react.copy()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnAction.setOnClickListener { switchCourse(current) }
    }

    private fun switchCourse(course: CoursesModel) {
        current = when (course.url) {
            CoursesEnum.REACT.url -> kot.copy()
            CoursesEnum.KOTLIN.url -> react.copy()
            else -> course.copy()
        }

        binding.tvMessage.text = getString(
            R.string.courses_messages, current.name, current.url
        )
    }

}