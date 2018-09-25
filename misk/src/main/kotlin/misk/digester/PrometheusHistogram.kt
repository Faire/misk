package misk.digester

import io.prometheus.client.CollectorRegistry
import io.prometheus.client.Histogram
import javax.inject.Inject


//Histogram for Prometheus
class PrometheusHistogram : HistogramInterface {
    @Inject lateinit var histogram: Histogram
    @Inject lateinit var collectorRegistry: CollectorRegistry

    companion object {
    //builds the histogram
        fun build(
            name: String,
            help: String,
            labelNames: List<String> = listOf()
        ): Histogram.Builder {
            //we can set the classes histogram instance from here?
            return Histogram.build(name, help).labelNames(*labelNames.toTypedArray())
        }
    }

    fun setPrometheusHistogram(histogram: Histogram) {
        this.histogram = histogram
    }

    //adds new label to histogram
    override fun labels(vararg labelValues: String): Histogram.Child {
        return histogram.labels(*labelValues)
    }
}