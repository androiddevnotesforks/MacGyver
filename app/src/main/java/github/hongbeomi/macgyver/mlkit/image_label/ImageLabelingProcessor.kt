package github.hongbeomi.macgyver.mlkit.image_label

import com.google.android.gms.tasks.Task
import com.google.mlkit.vision.label.ImageLabel
import com.google.mlkit.vision.label.ImageLabeling
import com.google.mlkit.vision.label.defaults.ImageLabelerOptions
import github.hongbeomi.macgyver.camerax.BaseImageAnalyzer

class ImageLabelingProcessor (override var doOnSuccess: (List<ImageLabel>) -> Unit) : BaseImageAnalyzer<List<ImageLabel>>() {

    private val options = ImageLabelerOptions.Builder().setConfidenceThreshold(0.5f).build()
    private val labeler = ImageLabeling.getClient(options)

    override val process: Task<List<ImageLabel>>?
        get() = image?.let { labeler.process(it) }

}