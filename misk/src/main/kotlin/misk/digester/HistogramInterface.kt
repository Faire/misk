package misk.digester

import io.prometheus.client.Histogram

//Skeleton interface for all histograms
interface HistogramInterface {

    //adds new value to histogram
    fun labels(vararg labelValues: String): Histogram.Child

}