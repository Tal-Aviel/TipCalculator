package il.ac.huji.tipcalculator;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalculatorActivity extends Activity {

    public static final double TIP_PERCENT = 0.12;
    private TextView txtTipResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);

        findViewById(R.id.btnCalculate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double bill;
                txtTipResult = (TextView) findViewById(R.id.txtTipResult);
                try {
                    bill = Double.parseDouble(((EditText) findViewById(R.id.edtBillAmount)).getText().toString());
                } catch(NumberFormatException e) {
                    txtTipResult.setVisibility(View.INVISIBLE);
                    return;
                }
                double tip = TIP_PERCENT * bill;
                if (((CheckBox)findViewById(R.id.chkRound)).isChecked()) {
                    tip = Math.ceil(tip);
                    txtTipResult.setText(String.format("Tip: $%.0f", tip));
                } else {
                    txtTipResult.setText(String.format("Tip: $%2.2f", tip));
                }
                txtTipResult.setVisibility(View.VISIBLE);
            }
        });
    }
}
