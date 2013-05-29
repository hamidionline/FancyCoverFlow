/*
 * Copyright 2013 David Schreiber
 *           2013 John Paul Nalog
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package at.technikum.mti.fancycoverflow.samples;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import at.technikum.mti.fancycoverflow.samples.example.SimpleExample;
import at.technikum.mti.fancycoverflow.samples.example.XmlInflateExample;

/**
 * Created by david on 29.05.13.
 */
public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setListAdapter(new ExampleAdapter());
    }

    // =============================================================================
    // Private classes
    // =============================================================================

    /**
     * TODO: Scan the example package for activities and show them automatically.
     */
    private static class ExampleAdapter extends BaseAdapter {

        // =============================================================================
        // Private members
        // =============================================================================

        private final Class[] exampleActivities = new Class[]{SimpleExample.class, XmlInflateExample.class};

        // =============================================================================
        // Supertype overrides
        // =============================================================================

        @Override
        public int getCount() {
            return this.exampleActivities.length;
        }

        @Override
        public Class getItem(int i) {
            return this.exampleActivities[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View reuseableView, ViewGroup viewGroup) {
            TextView view = null;

            if (reuseableView != null) {
                view = (TextView) reuseableView;
            } else {
                view = new TextView(viewGroup.getContext());
            }

            final Class activity = this.getItem(i);

            view.setText(activity.getName());
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(view.getContext(), activity);
                    view.getContext().startActivity(i);
                }
            });

            return view;
        }
    }
}