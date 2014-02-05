/**
 * Copyright (c) 2013 M. Alexander Nugent Consulting <i@alexnugent.name>
 *
 * M. Alexander Nugent Consulting Research License Agreement
 * Non-Commercial Academic Use Only
 *
 * This Software is proprietary. By installing, copying, or otherwise using this
 * Software, you agree to be bound by the terms of this license. If you do not agree,
 * do not install, copy, or use the Software. The Software is protected by copyright
 * and other intellectual property laws.
 *
 * You may use the Software for non-commercial academic purpose, subject to the following
 * restrictions. You may copy and use the Software for peer-review and methods verification
 * only. You may not create derivative works of the Software. You may not use or distribute
 * the Software or any derivative works in any form for commercial or non-commercial purposes.
 *
 * Violators will be prosecuted to the full extent of the law.
 *
 * All rights reserved. No warranty, explicit or implicit, provided.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRßANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.mancrd.ahah.samples.plosahah.model;

import java.util.Map;

import com.xeiam.xchart.BitmapEncoder;
import com.xeiam.xchart.CSVImporter;
import com.xeiam.xchart.CSVImporter.DataOrientation;
import com.xeiam.xchart.Chart;
import com.xeiam.xchart.Series;
import com.xeiam.xchart.SeriesLineStyle;
import com.xeiam.xchart.StyleManager.ChartTheme;
import com.xeiam.xchart.StyleManager.LegendPosition;
import com.xeiam.xchart.SwingWrapper;

/**
 * @author timmolter
 */
public class AgChalcPulseFigureC {

  public static void main(String[] args) throws Exception {

    // import chart from a folder containing CSV files
    Chart chart = CSVImporter.getChartFromCSVDir("./Results/Model/Circuit/AgChalcC", DataOrientation.Columns, 300, 270, ChartTheme.Matlab);
    chart.setYAxisTitle("Resistance [Ohm]");
    chart.setXAxisTitle("Pulse Number");
    chart.getStyleManager().setLegendPosition(LegendPosition.InsideNE);
    chart.getStyleManager().setPlotGridLinesVisible(false);

    Map<String, Series> seriesMap = chart.getSeriesMap();

    Series series0 = seriesMap.get("10 µs, 0.2 V, -0.5 V");
    series0.setLineStyle(SeriesLineStyle.NONE);

    Series series1 = seriesMap.get("10 µs, 0.8 V, -2.0 V");
    series1.setLineStyle(SeriesLineStyle.NONE);

    Series series2 = seriesMap.get("5 µs, 0.8 V, -2.0 V");
    series2.setLineStyle(SeriesLineStyle.NONE);

    // Show it
    new SwingWrapper(chart).displayChart();
    BitmapEncoder.savePNGWithDPI(chart, "./PLOS_AHAH/Figures/AgChalcHysteresisC.png", 300);
  }
}
