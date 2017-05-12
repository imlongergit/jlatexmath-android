package com.latex.example;

import android.app.Activity;
import android.os.Bundle;

import maximsblog.blogspot.com.jlatexmath.ui.FormulaView;

/**
 * @author liuxiaolong
 */
public class TestActivity extends Activity {

    private FormulaView formulaView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        formulaView = (FormulaView) findViewById(R.id.formula);
        formulaView.setTex("\\begin{array}{cc}"
                + "\\fbox{\\text{A framed box with \\textdbend}}&\\shadowbox{\\text{A shadowed box}}\\cr"
                + "\\doublebox{\\text{A double framed box}}&\\ovalbox{\\text{An oval framed box}}\\cr"
                + "\\end{array}");
    }
}
