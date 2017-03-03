# BottomNavigationBar
A light bottom navigation bar in Android supporting Tint mode.

Please star this library if you like it. :)

## Demo
![Demo](/pic/demo.gif)

## Usage
### 1.Get BottomNavigationBar from XML
    BottomNavigationBar bnb = (BottomNavigationBar) findViewById(R.id.bnb_default);

### 2.New BottomItem 

    Tint Mode: 
    BottomItem item = new BottomItem();
    item.setText("Bag");
    item.setIconResID(getResources().getIdentifier("ic_tint_bag", "drawable", mPackageName));
    bnb.addItem(item);
	
	Drawable Mode:
	BottomItem item = new BottomItem();
    item.setMode(BottomItem.DRAWABLE_MODE);
    item.setText("Camera");
    item.setActiveIconResID(getResources().getIdentifier("ic_drawable_camera_fill", "drawable",
            getApplicationInfo().packageName));
    item.setInactiveIconResID(getResources().getIdentifier("ic_drawable_camera", "drawable",
            getApplicationInfo().packageName));
    item.setActiveTextColor(Color.parseColor("#E64B4E"));
    bnb.addItem(item);
	
### 3.Init BottomNavigationBar
    bnb.addOnSelectedListener(new BottomNavigationBar.OnSelectedListener() {
        @Override
        public void OnSelected(int oldPosition, int newPosition) {
            //ToDo: Do anything you want, transforming fragment etc.
        }
    });
	bnb.setSelectedPosition(2); //Set default item
	bnb.initialize();

## License
```
Copyright 2016 Vincent Woo

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```